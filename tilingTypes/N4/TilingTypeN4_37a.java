package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_37a
   extends TilingType
{
   public TilingTypeN4_37a(){
      super( "N4-37a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{"Offset"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 2,4, 0,2,1, 0},
            {0, 0,1, 2,0,1, 1},
            
            {0, 3,2, 0,2,3, 0},
            {1, 0,1, 4,0,1, 1},
            {1, 2,4, 4,2,1, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "2a=c=d\nA=90\n2C+D=180\n(B=126)\n(C=36)\n(D=108)";
      labels = new int[]{0,1,2,-1,3};
   }

   public void recalcBase(double[] paramValues) {
      final double ln = .4;
      final double dx1 = 2*ln * Math.cos(18*DEG2RAD); 
      final double dy1 = 2*ln * Math.sin(18*DEG2RAD); 
      final double dx2 = 2*ln * Math.cos(-126*DEG2RAD); 
      final double dy2 = 2*ln * Math.sin(-126*DEG2RAD); 
      double os = getParam(paramValues,0)/100;
    
      baseTile.setPoint(0, 0,       0);
      baseTile.setPoint(1, dx1+dx2, ln+dy1+dy2);
      baseTile.setPoint(2, dx1,     ln+dy1);
      baseTile.setPoint(3, dx1*os,  ln+dy1*os);
      baseTile.setPoint(4, 0,       ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(3);
   }
}
