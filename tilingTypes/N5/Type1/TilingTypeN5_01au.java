package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01au
   extends TilingType
{
   public TilingTypeN5_01au(){
      super( "N5-1au", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{100};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 2,1, 0,1,2, 0},
            {1, 0,1, 2,0,1, 1},
            
            {0, 4,0, 0,3,4, 1},
            {1, 0,1, 4,0,1, 0},
            {0, 2,1, 4,1,2, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "d=c+e\nA=90\nC+D=180\n2B+C=360\n(B+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double d = getParam(paramValues,0);
      double h = Math.cos(d/2*DEG2RAD);
      double w = Math.sqrt(1-h*h);
      
      // width = w*(2 + 1/4h)
      // height = 1+2h
      // 
      double lna = 1.5 / (1+2*h+w*(2+1/h/4));
      double dx = w * lna * 2;
      double dy = h * lna * 2;
      double dx2 = w * lna / h / 2;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, 2*dx, 0);
      baseTile.setPoint(2, 2*dx+dx2, lna/2);
      baseTile.setPoint(3,   dx, dy+lna);
      baseTile.setPoint(4,    0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[3].getX(2);
      offsets[1] = tiles[1].getY(3)-tiles[3].getY(2);
      offsets[2] = tiles[2].getX(4)-tiles[6].getX(3);
      offsets[3] = tiles[2].getY(4)-tiles[6].getY(3);
   }
}
