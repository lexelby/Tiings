package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_38
   extends TilingType
{
   public TilingTypeN4_38(){
      super( "N4-38", 4, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,1, 0},
            {1, 0,3, 1,0,1, 0},
            {1, 0,3, 2,0,1, 0},
            {1, 0,3, 3,0,1, 0},
            {1, 0,3, 4,0,1, 0},
            
            {0, 0,3, 0,2,3, 0},            
            {0, 0,3, 1,2,3, 0},            
            {0, 0,3, 2,2,3, 0},            
            {0, 0,3, 3,2,3, 0},            
            {0, 0,3, 4,2,3, 0},            
            {0, 0,3, 5,2,3, 0},            
      };
      info = "a=b\nc=d\nA=60\nC=120\n(B=90)\n(D=90)";
   }

   public void recalcBase(double[] paramValues) {
      final double h = .4;
      final double w = h*Math.sqrt(3); 
      final double w2 = w*4/3; 
    
      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w, -h);
      baseTile.setPoint(2,w2,  0);
      baseTile.setPoint(3, w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(2)-tiles[8].getX(2);
      offsets[1] = tiles[6].getY(2)-tiles[8].getY(2);
      offsets[2] = tiles[6].getX(2)-tiles[10].getX(2);
      offsets[3] = tiles[6].getY(2)-tiles[10].getY(2);
   }
}
