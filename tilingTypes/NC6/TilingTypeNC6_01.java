package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_01
   extends TilingType
{
   public TilingTypeNC6_01(){
      super( "NC6-1", 6, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 2,1, 0,2,3, 0},
            {1, 2,1, 1,2,3, 0},
            {1, 2,1, 2,2,3, 0},
            {1, 2,1, 3,2,3, 0},
            {1, 2,1, 4,2,3, 0},
            
            {0, 2,4, 0,4,0, 1},
            {0, 2,4, 1,4,0, 1},
            {0, 2,4, 2,4,0, 1},
            {0, 2,4, 3,4,0, 1},
            {0, 2,4, 4,4,0, 1},
            {0, 2,4, 5,4,0, 1},
      };
      info = "a=b=e\nc=d=f\nA=120\nB=90\nC=60\nD=270\nE=90\n(F=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .25;
      double h = w * Math.sqrt(3);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,3*w, -h);
      baseTile.setPoint(2,4*w,  0);
      baseTile.setPoint(3,2*w,  0);
      baseTile.setPoint(4,2*w,2*h);
      baseTile.setPoint(5,  0,2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[8].getX(0)-tiles[6].getX(0);
      offsets[1] = tiles[8].getY(0)-tiles[6].getY(0);
      offsets[2] = tiles[10].getX(0)-tiles[6].getX(0);
      offsets[3] = tiles[10].getY(0)-tiles[6].getY(0);
   }
}