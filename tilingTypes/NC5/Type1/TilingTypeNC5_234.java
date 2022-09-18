package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_234
   extends TilingType
{
   public TilingTypeNC5_234(){
      super( "NC5-234", 5, SymmetryType.pgg);

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 4,3, 0,3,4, 0},
            {1, 1,0, 1,0,1, 0},
            {1, 4,0, 2,0,4, 0},
            {0, 0,1, 3,1,0, 0},
            {2, 4,3, 4,3,4, 0},
            
            {2, 0,1, 3,3,4, 1},
            {0, 4,3, 6,3,4, 1},
            {1, 1,0, 7,0,1, 1},
            {1, 4,0, 8,0,4, 1},
            {0, 0,1, 9,1,0, 1},
            {2, 4,3,10,3,4, 1},
      };
      info = "a=c=2d\nd=e\nb=3d\nA=60\nB=60\nC=60\nD=300\n(E=60)";
   }
   public void recalcBase(double[] paramValues) {
      double ln = .2;
      double h = ln * Math.sqrt(3);
      
      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1, ln*6,  0);
      baseTile.setPoint(2, ln*4,  h*2);
      baseTile.setPoint(3, ln*3,  h);
      baseTile.setPoint(4, ln*2,  h*2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[5].getX(1);
      offsets[1] = tiles[2].getY(2)-tiles[5].getY(1);
      offsets[2] = tiles[4].getX(2)-tiles[11].getX(1);
      offsets[3] = tiles[4].getY(2)-tiles[11].getY(1);
   }
}
